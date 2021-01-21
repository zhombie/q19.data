package kz.q19.data

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kz.q19.data.api.model.response.configs.ConfigsResponse
import kz.q19.data.api.model.response.configs.toDomain
import kz.q19.data.api.model.response.form.FormResponse
import kz.q19.data.api.model.response.form.toDomain
import kz.q19.data.api.model.response.geo.LocationResponse
import kz.q19.data.api.model.response.geo.toDomain

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val configsResponse = ConfigsResponse(configs = null, booleans = null, callScopes = null)
        print(configsResponse.toDomain())

        val formResponse = FormResponse(
            id = -1,
            title = "",
            isFlex = 0,
            prompt = null,
            fields = emptyList(),
            configs = null
        )
        print(formResponse.toDomain())

        val locationResponse = LocationResponse(latitude = 0.0, longitude = 0.0)
        print(locationResponse.toDomain())
    }

}