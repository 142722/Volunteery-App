//package com.example.volunteeryapp.Data
//import android.app.ProgressDialog
//import android.content.Context
//import android.widget.Toast
//import androidx.navigation.NavController
//import com.example.volunteeryapp.Models.User
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.database.FirebaseDatabase
//
//class UserViewModel(private val context: Context) {
//    private val auth = FirebaseAuth.getInstance()
//    private val database = FirebaseDatabase.getInstance()
//
//    fun saveUserProfile(user: User) {
//        val userRef = database.getReference("Users/${auth.currentUser?.uid}")
//        userRef.setValue(user)
//            .addOnSuccessListener {
//                Toast.makeText(context, "User profile saved successfully", Toast.LENGTH_SHORT).show()
//            }
//            .addOnFailureListener {
//                Toast.makeText(context, "Failed to save user profile: ${it.message}", Toast.LENGTH_SHORT).show()
//            }
//    }
//
//    fun deleteUserProfile() {
//        val userRef = database.getReference("Users/${auth.currentUser?.uid}")
//        userRef.removeValue()
//            .addOnSuccessListener {
//                Toast.makeText(context, "User profile deleted successfully", Toast.LENGTH_SHORT).show()
//            }
//            .addOnFailureListener {
//                Toast.makeText(context, "Failed to delete user profile: ${it.message}", Toast.LENGTH_SHORT).show()
//            }
//    }
//}
