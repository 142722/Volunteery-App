package com.example.volunteeryapp.Data

import com.example.volunteeryapp.Navigations.ROUTE_DASHBOARD
import com.example.volunteeryapp.Navigations.ROUTE_LOGIN
import com.example.volunteeryapp.Navigations.ROUTE_REGISTER
import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import com.example.volunteeryapp.Models.User
import com.example.volunteeryapp.Navigations.ROUTE_DASHBOARDORG
import com.example.volunteeryapp.Navigations.ROUTE_JOIN
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class AuthViewModel(var navController: NavController, var context: Context) {

    var mAuth: FirebaseAuth
    val progress: ProgressDialog

    init {
        mAuth = FirebaseAuth.getInstance()
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("PLease Wait.....")
    }


//    fun isLoggedIn(): Boolean {
//        val currentUser = FirebaseAuth.getInstance().currentUser
//        return currentUser != null
//    }

    fun register(
        fullname: String,
        email: String,
        password: String,
        confirmPassword: String
    ) {
//       progress.show()

        if (fullname.isBlank() || email.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
//            progress.dismiss()
            Toast.makeText(context, "Please Fill In all The Forms blank", Toast.LENGTH_LONG).show()
            return
//
        } else if (password != confirmPassword) {
            Toast.makeText(context, "Password do not match", Toast.LENGTH_LONG).show()
            return
        } else {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful) {
                    val userdata = User(fullname, email, password, mAuth.currentUser!!.uid)
                    val regRef = FirebaseDatabase.getInstance().getReference()
                        .child("User/" + mAuth.currentUser!!.uid)
                    regRef.setValue(userdata).addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(context, "Registered Successfully", Toast.LENGTH_LONG)
                                .show()
                            navController.navigate(ROUTE_DASHBOARD)

                        } else {
                            Toast.makeText(context, "${it.exception!!.message}", Toast.LENGTH_LONG)
                                .show()
                            navController.navigate(ROUTE_REGISTER)
                        }
                    }
                } else {
                    navController.navigate(ROUTE_REGISTER)
                }

            }
        }
    }

    //    fun registerorg(
//        fullname: String,
//        email: String,
//        password: String,
//        confirmPassword:String,
//        organisationname:String
//    ){
////       progress.show()
//
//        if (fullname.isBlank()  ||  email.isBlank() || password.isBlank() || confirmPassword.isBlank() ) {
////            progress.dismiss()
//            Toast.makeText(context, "Please Fill In all The Forms blank", Toast.LENGTH_LONG).show()
//            return
////
//        }else if (password != confirmPassword){
//            Toast.makeText(context,"Password do not match",Toast.LENGTH_LONG).show()
//            return
//        }else{
//            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
//                if (it.isSuccessful){
//                    val userdata=User(fullname, email,password, mAuth.currentUser!!.uid)
//                    val regRef= FirebaseDatabase.getInstance().getReference()
//                        .child("User/"+mAuth.currentUser!!.uid)
//                    regRef.setValue(userdata).addOnCompleteListener {
//                        if (it.isSuccessful){
//                            Toast.makeText(context,"Registered Successfully",Toast.LENGTH_LONG).show()
//                            navController.navigate(ROUTE_DASHBOARD)
//
//                        }else{
//                            Toast.makeText(context,"${it.exception!!.message}",Toast.LENGTH_LONG).show()
//                            navController.navigate(ROUTE_REGISTER)
//                        }
//                    }
//                }else{
//                    navController.navigate(ROUTE_REGISTER)
//                }
//
//            }
//        }
//    }
    fun login(Email: String, Password: String) {
        progress.show()

        mAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful) {
                Toast.makeText(context, "Succeffully Logged in", Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_DASHBOARD)
//                navController.navigate(ROUTE_REGISTER)TO TAKE YOU TO A DIIFFERNT PAGE
            } else {
                Toast.makeText(context, "${it.exception!!.message}", Toast.LENGTH_LONG).show()
                navController.navigate(ROUTE_LOGIN)
            }
        }
    }

    fun logout() {
        mAuth.signOut()
        navController.navigate(ROUTE_JOIN)
    }

    fun isLoggedIn(): Boolean {
        return mAuth.currentUser != null
    }
}

//    fun User(
//        user: MutableState<User>,
//        users: SnapshotStateList<User>
//    ): SnapshotStateList<User> {
//        progress.show()
//        var ref = FirebaseDatabase.getInstance().getReference()
//            .child("Users/"+mAuth.currentUser!!.uid)
//        ref.addValueEventListener(object : ValueEventListener {
//            override fun onDataChange(snapshot: DataSnapshot) {
//                users.clear()
//                for (snap in snapshot.children) {
//                    var retrieveduserdata = snap.getValue(User::class.java)
//                    user.value = retrieveduserdata!!
//                    users.add(retrieveduserdata)
//                }
//                progress.dismiss()
//            }
//
//            override fun onCancelled(error: DatabaseError) {
//                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
//            }
//        })
//        return users
//    }
//
//
//
//}