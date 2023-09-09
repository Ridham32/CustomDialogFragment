package com.ridhamsharma.customDialogFragment

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import com.ridhamsharma.customDialogFragment.databinding.MydialogBinding

interface DialogClickInterface {
    fun onDialogDismissClick(name :String)

}

class MyFragmentDialog: DialogFragment() {
    lateinit var fragmentDialog : Dialog
    lateinit var binding : MydialogBinding
    lateinit var dialogClickInterface : DialogClickInterface

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        fragmentDialog = Dialog(requireContext())
        binding = MydialogBinding.inflate(layoutInflater)
        fragmentDialog.setContentView(binding.root)

        binding.btnAdd.setOnClickListener {
            if (binding.etName.text.toString().isNullOrEmpty()) {
                binding.etName.error = "Enter The Name"
            } else {
                dialogClickInterface.onDialogDismissClick(binding.btnAdd.text.toString())
                fragmentDialog.dismiss()
            }
        }
        return fragmentDialog
    }

    companion object{
        var TAG = this::class.java.canonicalName
    }




}