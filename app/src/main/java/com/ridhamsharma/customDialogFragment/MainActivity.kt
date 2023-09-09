package com.ridhamsharma.customDialogFragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.ridhamsharma.btmsheetndialog.databinding.MydialogBinding

class MainActivity : AppCompatActivity() ,  DialogClickInterface {
    private lateinit var binding: MydialogBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = MydialogBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
    }
    fun buttonClick(mainClickTypes: MainClickTypes) {
        when(mainClickTypes) {
                MainClickTypes.OpenFragment -> {
                val dialogClass = MyFragmentDialog()
                dialogClass.dialogClickInterface = this
                dialogClass.show(supportFragmentManager,MyFragmentDialog.TAG)
            }
            MainClickTypes.CustomClick -> {
                Toast.makeText(this,"Clicked ADD from Custom Fragment",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDialogDismissClick(name: String) {
        binding.root.let {
            Snackbar.make(it, "Clicked item $name", Snackbar.LENGTH_SHORT).show()
        }
    }
}