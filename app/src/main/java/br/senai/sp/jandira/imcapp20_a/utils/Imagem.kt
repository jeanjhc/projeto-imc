package br.senai.sp.jandira.imcapp20_a.utils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import java.io.ByteArrayOutputStream

fun converterBitmapParaBytearray(imagem: Bitmap?): ByteArray?{
    val stream = ByteArrayOutputStream()

    if (imagem!=null) {
        val imageArray = imagem!!.compress(Bitmap.CompressFormat.PNG, 0, stream)
        return stream.toByteArray()
    }

    return null
}

fun converterByteArrayParaBitmap(imageArray:ByteArray):Bitmap {
    return BitmapFactory.decodeByteArray(imageArray, 0, imageArray.size)
}

fun converteBitmapParaBase64(imagem: Bitmap) :String{
    val imageArray = converterBitmapParaBytearray(imagem)
    return Base64.encodeToString(imageArray, Base64.DEFAULT)
}
fun converterbase64ParaBitmap(image64: String?) :Bitmap{
    var imageArray = Base64.decode(image64, Base64.DEFAULT)
    return converterByteArrayParaBitmap(imageArray)
}


//BANCO(BITE MAP) -> sHAREDpREFERENCES(BASE64) -> IMAGEvIEW(BYTE MAP)