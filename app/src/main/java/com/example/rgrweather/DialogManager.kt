package com.example.rgrweather

import android.app.AlertDialog
import android.content.Context
import android.widget.EditText

object DialogManager {
    fun setDialog(context: Context, listener: Listener){
        val builder = AlertDialog.Builder(context)
        val dialog = builder.create()
        dialog.setTitle("Enable location?")
        dialog.setMessage("Location disabled, do you want to enable location")
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK"){
                _,_,->listener.onClikc(null)
                dialog.dismiss()
            }
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Canel"){
                _,_,->
            dialog.dismiss()
        }
        dialog.show()
    }
    interface Listener{
        fun onClikc(name: String?)
    }
    fun search(context: Context, listener: Listener){
        val builder = AlertDialog.Builder(context)
        val edName = EditText(context)
        builder.setView(edName)
        val dialog = builder.create()
        dialog.setTitle("City name:")
        dialog.setMessage("Location disabled, do you want to enable location")
        dialog.setButton(AlertDialog.BUTTON_POSITIVE, "OK"){
                _,_,->listener.onClikc(edName.text.toString())
            dialog.dismiss()
        }
        dialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Canel"){
                _,_,->
            dialog.dismiss()
        }
        dialog.show()
    }
}