package com.yandex.mobius360quest

import android.os.Bundle
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.yandex.mobius360quest.databinding.AuthFragmentBinding
import com.yandex.mobius360quest.to_hide.BaseViewBindingFragment

class Auth : BaseViewBindingFragment<AuthFragmentBinding>(AuthFragmentBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.auth.setOnClickListener {
            login(binding.inputLogin.toString(), binding.inputPassword.toString())
        }
        val removeError = { _: CharSequence?, _: Int, _: Int, _: Int ->
            binding.inputLoginLayout.error = null
            binding.inputPasswordLayout.error = null
        }
        binding.inputLogin.doOnTextChanged(removeError)
        binding.inputPassword.doOnTextChanged(removeError)
        binding.resetPassword.setOnClickListener {
            findNavController().navigate(R.id.step_to_next)
        }
    }

    // NAIDI LOGIN+PASS V KODE AHAHAHAHAH
    private fun login(login: String, password: String) {
        // add login+password check
        binding.inputLoginLayout.error = " "
        binding.inputPasswordLayout.error = "failed"
    }
}