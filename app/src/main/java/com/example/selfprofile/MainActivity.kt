package com.example.selfprofile

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var namaInput: String = ""
    var emaillInput: String = ""
    var telpInput: String = ""
    var alamatInput: String = ""
    var genderInput: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Save.setOnClickListener {
            validasiInput()
        }
        setDataSpinnerGener()
    }

    private fun setDataSpinnerGener() {
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.gender_list, android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerGender.adapter = adapter

    }

    private fun validasiInput() {
        namaInput = edtName.text.toString()
        emaillInput = edtEmail.text.toString()
        telpInput = edtTelp.text.toString()
        alamatInput = edtAdress.text.toString()
        genderInput = spinnerGender.selectedItem.toString()

        when {


            namaInput.isEmpty() -> edtName.error = "Nama tidak boleh kosong"
            genderInput.equals("Pilih Kelamin") -> tampilToast("Kelamin harus dipilih")
            emaillInput.isEmpty() -> edtEmail.error = "Email tidak boleh kosong"
            telpInput.isEmpty() -> edtTelp.error = "Telp tidak boleh kosong"
            alamatInput.isEmpty() -> edtAdress.error = "Alamat tidak boleh kosong"

            else -> {

                tampilToast("yay bisa!!!")
                navigasikeProfilDiri()

            }
        }
    }

    private fun navigasikeProfilDiri() {

        val intent = Intent(this, SelfProfile::class.java)

        val bundle = Bundle()
        bundle.putString("nama", namaInput)
        bundle.putString("gender", genderInput)
        bundle.putString("email", emaillInput)
        bundle.putString("telp", telpInput)
        bundle.putString("alamat", alamatInput)

        intent.putExtras(bundle)
        startActivity(intent)
    }

    private fun tampilToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}




