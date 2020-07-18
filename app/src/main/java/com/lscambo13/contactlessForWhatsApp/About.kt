package com.lscambo13.contactlessForWhatsApp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView

class About : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val adView = findViewById<AdView>(R.id.adView)
        val adReq = AdRequest.Builder().build()

        adView.loadAd(adReq)

        adView.adListener = object: AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdFailedToLoad(errorCode : Int) {
                adView.loadAd(adReq)
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        }

        val close: Button = findViewById(R.id.closeAbt)
        val newVer: Button = findViewById(R.id.DwnNewVer)
        val shr: ImageView = findViewById(R.id.share)
        val telegram: ImageView = findViewById(R.id.telegram)
        val summary: TextView = findViewById(R.id.summary)
        val aboutText = getText(R.string.about_text)

        close.setOnClickListener {
            onBackPressed()
        }

        newVer.setOnClickListener {
            val updateLink = "https://bit.ly/3gWV4rL"
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(updateLink)

            adView.loadAd(adReq)
            startActivity(openURL)
        }

        telegram.setOnClickListener {
            val supportLink = "https://t.me/lscambo13_projects"
            val openURL = Intent(Intent.ACTION_VIEW)
            openURL.data = Uri.parse(supportLink)
            startActivity(openURL)
        }

        shr.setOnClickListener {
            intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            val message = "Check out this amazing app that lets you chat with someone on WhatsApp without needing to save their phone number\nbit.ly/3gWV4rL"
            intent.putExtra(Intent.EXTRA_TEXT, message)
            startActivity(Intent.createChooser(intent, "Show Love by Sharing"))
        }

        summary.setOnClickListener {

            adView.loadAd(adReq)
            if(summary.text != getString(R.string.easter_egg))
                summary.text = getString(R.string.easter_egg)
            else
                summary.text = aboutText.toString()

        }
    }
}

