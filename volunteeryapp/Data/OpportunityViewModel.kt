package com.example.volunteeryapp.Data
import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import com.example.volunteeryapp.Models.Opportunity
import com.google.firebase.database.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.volunteeryapp.Navigations.ROUTE_LOGIN

class OpportunityViewModel(var navController: NavController, var context: Context) {
    var authRepository: AuthViewModel
    var progress: ProgressDialog

    init {
        authRepository = AuthViewModel(navController, context)
        if (!authRepository.isLoggedIn()) {
            navController.navigate(ROUTE_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    fun saveOpportunity(title: String, description: String, location: String, date: String,duration:String) {
        val id = System.currentTimeMillis().toString()
        val opportunityData = Opportunity(id, title, description, location, date,duration)
        val opportunityRef = FirebaseDatabase.getInstance().getReference("Opportunity").child(id)
        progress.show()
        opportunityRef.setValue(opportunityData).addOnCompleteListener { task ->
            progress.dismiss()
            if (task.isSuccessful) {
                Toast.makeText(context, "Saving successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "ERROR: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun viewOpportunity(
        opportunity: MutableState<Opportunity>,
        opportunitys: SnapshotStateList<Opportunity>
    ): SnapshotStateList<Opportunity> {
        val ref = FirebaseDatabase.getInstance().getReference().child("Opportunity")

        //progress.show()
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                //progress.dismiss()
                opportunitys.clear()
                for (snap in snapshot.children) {
                    val value = snap.getValue(Opportunity::class.java)
                    opportunity.value = value!!
                    opportunitys.add(value)

                }
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })
        return opportunitys
    }

    fun deleteOpportunity(id: String) {
        var delRef = FirebaseDatabase.getInstance().getReference()
            .child("Opportunitys/$id")
        progress.show()
        delRef.removeValue().addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Product deleted", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, it.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun updateOpportunity( title: String, description: String, location: String, date: String,duration: String) {
        var id = System.currentTimeMillis().toString()
        var updateRef = FirebaseDatabase.getInstance().getReference("Opportunity").child(id)
        var opportunityData = Opportunity(id, title, description, location,date,duration)
        progress.show()
        var updateData = Opportunity(id, title, description, location, date, duration)
        updateRef.setValue(updateData).addOnCompleteListener { task ->
            progress.dismiss()
            if (task.isSuccessful) {
                Toast.makeText(context, "Update successful", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, task.exception?.message, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
