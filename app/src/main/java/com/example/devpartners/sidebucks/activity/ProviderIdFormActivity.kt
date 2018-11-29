package com.example.devpartners.sidebucks.activity

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.MenuItem
import com.example.devpartners.sidebucks.R
import com.example.devpartners.sidebucks.enum.OpenGallery
import kotlinx.android.synthetic.main.activity_provider_id_form.*
import org.jetbrains.anko.startActivity

@Suppress("DEPRECATED_IDENTITY_EQUALS")
class ProviderIdFormActivity : AppCompatActivity() {
    var bitmapImage : Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Back"
        setContentView(R.layout.activity_provider_id_form)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

        browseClearance.setOnClickListener {
            requestPermission(OpenGallery.CLEARANCE)
        }
        browseID.setOnClickListener {
            requestPermission(OpenGallery.ID)
        }
        submitButton.setOnClickListener {
            startActivity<ProviderSuccessActivity>()
            finish()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId) {
            android.R.id.home -> {
                this.finish()
            }
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode === Activity.RESULT_OK) {

            if (requestCode === OpenGallery.ID.getValue()) {
                bitmapImage = MediaStore.Images.Media.getBitmap(contentResolver, data?.data )
                imageID.setImageBitmap(MediaStore.Images.Media.getBitmap(contentResolver, data?.data))
            }
            else if (requestCode === OpenGallery.CLEARANCE.getValue()) {
                bitmapImage = MediaStore.Images.Media.getBitmap(contentResolver, data?.data )
                imageClearance.setImageBitmap(MediaStore.Images.Media.getBitmap(contentResolver, data?.data))
            }
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == OpenGallery.ID.getValue() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            openFilePicker(OpenGallery.ID)
        }
        else if (requestCode == OpenGallery.CLEARANCE.getValue() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            openFilePicker(OpenGallery.CLEARANCE)
        }
    }

    private fun openFilePicker(data : OpenGallery) {
        var intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, data.getValue())

    }
    private fun requestPermission(data : OpenGallery) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(arrayOf(android.Manifest.permission.WRITE_EXTERNAL_STORAGE), data.getValue())
        } else {
            openFilePicker(data)
        }
    }
}
