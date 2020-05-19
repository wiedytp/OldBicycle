package com.dicoding.picodiploma.oldbicycle

object BicycleData {
    private val bicycleNames = arrayOf(
        "Fongers",
        "BSA",
        "Raleigh",
        "Simplex",
        "Gazelle",
        "Batavus",
        "Sparta",
        "Magneet",
        "Phoenix",
        "Burgers"
    )

    private val bicycleDetails = arrayOf(
        "Pendiri Fongers adalah Albert Fongers di Hereweg, Groningen,Belanda tahun 1884",
        "BSA(Birmingham Small Arms Company Limited) diproduksi oleh anak perusahaan Muragapa Group (India) yaitu TI Cycles di Inggris tahun 1922",
        "Diproduksi oleh The Raleigh Cycle Corp di Raleigh Street,Nottingham, Inggris tahun 1866",
        "Diproduksi oleh Simplex Automatic Machine Company yang berada di Utrecht Stationdwarsstraat, Belanda tahun 1890",
        "Pendiri Gazelle adalah Willem Kolling dan Rudolf Arentzen di Dieren, Belanda tahun 1892",
        "Pendirinya adalah Andries Gaastra di kota Heerenveen, Belanda tahun 1909",
        "Produsen sepeda asal Belanda yang berdiri tahun 1917 di kota Apeldoorn",
        "Diproduksi oleh perusahaan Magneet Rijwiel en Motorenfabriek NV di Belanda tahun 1922",
        "Dibuat oleh Phoenix Company Ltd. di China tahun 1958",
        "Pabrik sepeda pertama yang dibuat oleh Henricus Burgers 1868 di kota Deventer, Belanda"
    )

    private val bicycleCountry = arrayOf(
        "Belanda",
        "Inggris",
        "Inggris",
        "Belanda",
        "Belanda",
        "Belanda",
        "Belanda",
        "Belanda",
        "China",
        "Belanda"
    )

    private val bicycleImages = intArrayOf(
        R.drawable.fongers,
        R.drawable.bsa,
        R.drawable.raleigh,
        R.drawable.simplex,
        R.drawable.gazelle,
        R.drawable.batavus,
        R.drawable.sparta,
        R.drawable.magneet,
        R.drawable.phoenix,
        R.drawable.burgers
    )

    val listData: ArrayList<Bicycle>
        get() {
            val list = arrayListOf<Bicycle>()
            for (position in bicycleNames.indices) {
                val bicycle = Bicycle()
                bicycle.name = bicycleNames[position]
                bicycle.detail = bicycleDetails[position]
                bicycle.country = bicycleCountry[position]
                bicycle.photo = bicycleImages[position]
                list.add(bicycle)
            }
            return list
        }
}