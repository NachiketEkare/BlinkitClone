package com.example.myapplication.utils

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.Toast
import com.example.myapplication.databinding.ProgressDialogBinding
import com.google.firebase.auth.FirebaseAuth

object Utils {

    private var dialog: AlertDialog? = null

    fun showDialog(context: Context,message: String){
        val progress = ProgressDialogBinding.inflate(LayoutInflater.from(context))
        progress.tvMessage.text = message
        dialog = AlertDialog.Builder(context).setView(progress.root).setCancelable(false).create()
        dialog!!.show()
    }

    fun hideDialog(){
        dialog?.dismiss()
    }

    fun Showtoastmsg(context: Context,message:String){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show()
    }

    private var firebaseAuthinstance:FirebaseAuth? = null

    fun firebaseinstance():FirebaseAuth{
        if (firebaseAuthinstance == null){
            firebaseAuthinstance = FirebaseAuth.getInstance()
        }
        return firebaseAuthinstance!!
    }

    fun getCurrentUserId():String? {
        return FirebaseAuth.getInstance().currentUser?.uid
    }

}