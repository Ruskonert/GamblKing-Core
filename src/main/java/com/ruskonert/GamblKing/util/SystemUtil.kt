@file:JvmName("SystemUtil")
package com.ruskonert.GamblKing.util

import com.google.gson.Gson
import com.google.gson.JsonElement
import javafx.application.Platform
import javafx.scene.control.Alert
import java.io.*
import java.net.URL
import javax.swing.JOptionPane

class SystemUtil
{
    companion object
    {
        fun fixHashMap(json: String): String
        {
            var s = json.replace("\\\\".toRegex(), "")
            s = s.replaceFirst("\"".toRegex(), "")
            return s
        }

        fun getMapFromJson(json: JsonElement): Map<*, *>? {
            return Gson().fromJson(fixHashMap(json.toString()), Map::class.java)
        }



        fun error(e : Exception)
        {
            val stes = e.stackTrace
            val builder = StringBuilder()
            builder.append("예외처리 오류가 발생하였습니다.\n")
            builder.append("자세한 오류 내용은 아래 내용을 참고하십시오.\n\n")
            builder.append("Caused by: ")
            builder.append(e.toString() + "\n")
            for (ste in stes) builder.append(ste).append("\n")
            JOptionPane.showMessageDialog(null, builder.toString(), "예외처리 발생", JOptionPane.ERROR_MESSAGE)
            System.exit(-1)
        }


        fun getStylePath(filename : String) : URL = this::class.java.getResource(filename).toURI().toURL()

        private var count : Int = 0

        @Throws(IOException::class, ClassNotFoundException::class)
        fun arrayToObject(buf: ByteArray): Any
        {
            val bis = ByteArrayInputStream(buf)
            val `in` = ObjectInputStream(bis)
            return `in`.readObject()
        }

        @Throws(IOException::class)
        fun objectToArray(obj: Any): ByteArray
        {
            val bos = ByteArrayOutputStream()
            val out = ObjectOutputStream(bos)
            out.writeObject(obj)
            return bos.toByteArray()
        }

        fun getStyleURL(filename: String): URL
        {
            return getStylePath("/style/" + filename)
        }

        fun getLayout(clazz: Class<*>): URL
        {
            return  this::class.java.getResource("/style/" + clazz.simpleName + ".fxml")
        }

        fun alert(title : String, headerText : String, content : String)
        {
            alert(title, headerText, content, Alert.AlertType.ERROR)
        }

        fun alert(title : String, headerText : String, content : String, type : Alert.AlertType)
        {
            Platform.runLater({
                val alert = Alert(type)
                alert.title = title
                alert.headerText = headerText
                alert.contentText = content
                alert.showAndWait()
            })
        }


    }
}