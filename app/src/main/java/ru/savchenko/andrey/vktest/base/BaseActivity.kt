package ru.savchenko.andrey.vktest.base

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import com.arellomobile.mvp.MvpAppCompatActivity
import ru.savchenko.andrey.vktest.R


/**
 * Created by savchenko on 13.02.18.
 */
@SuppressLint("Registered")
open class BaseActivity : MvpAppCompatActivity(), BaseView {
    lateinit var errordialog: AlertDialog
    lateinit var dialog: ProgressDialog

    protected fun initBackButton() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportActionBar?.setDisplayShowHomeEnabled(true);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setDialogTitleAndText("Загрузка данных", "Ожидайте")
    }

    override fun showDialog() {
        dialog.show()
    }

    protected fun setDialogTitleAndText(title: String, message: String) {
        dialog = ProgressDialog(this)
        dialog.setCancelable(false)
        dialog.setMessage(message)
        dialog.setTitle(title)
    }

    override fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun hideDialog() {
        dialog.dismiss()
    }

    override fun changeToolbarTitle(title: String) {
        val actionBar = supportActionBar
        println("actionBar $actionBar")
        if (actionBar != null)
            actionBar.title = title
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun showError(error: String){
        val builder = AlertDialog.Builder(this, R.style.MyDialogTheme)
        builder.setTitle("Ошибка")
                .setMessage(error)
                .setCancelable(false)
                .setPositiveButton("ОК", { dialog, _ -> dialog.dismiss() })
        errordialog = builder.create()
        errordialog.show()
    }

    fun showConfirmDialog(title: String = "",
                          message: String = "",
                          positive: () -> Unit,
                          negative: (() -> Unit)? = null)  {
        showNotCancelableDialog(this,
                title = "Внимание! Удалить документ?",
                positiveClick = DialogInterface.OnClickListener { dialog, _ ->
                    positive.invoke()
                },
                negativeClick = DialogInterface.OnClickListener { dialog, _ ->
                    negative?.invoke()
                })
    }

    fun showNotCancelableDialog(context: Context,
                                title: String = "",
                                message: String = "",
                                positiveClick: DialogInterface.OnClickListener,
                                negativeClick: DialogInterface.OnClickListener) {
        val dialog = android.support.v7.app.AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("Да", positiveClick)
                .setNegativeButton("Нет", negativeClick).create()
        dialog.setOnShowListener {
            dialog.getButton(android.support.v7.app.AlertDialog.BUTTON_NEGATIVE).setTextColor(context.resources.getColor(android.R.color.background_dark))
            dialog.getButton(android.support.v7.app.AlertDialog.BUTTON_POSITIVE).setTextColor(context.resources.getColor(android.R.color.background_dark))
        }
        dialog.show()
    }
}