package com.example.jetnumbers.presentation

import android.content.Context
import android.content.res.ColorStateList
import android.view.View.OnClickListener
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import com.example.jetnumbers.R
import com.example.jetnumbers.domain.entity.GameResult

@BindingAdapter("requiredAnswers")
fun bindRequiredAnswers(textView: TextView, count:Int)  {
    textView.text = String.format(
    textView.context.getString(R.string.required_score),
    count
    )
}
@BindingAdapter("scoreAnswers")
fun bindScoreAnswers(textView: TextView,count: Int){
    textView.text = String.format(
        textView.context.getString(R.string.score_answers),
        count
    )
}
@BindingAdapter("requiredPercentage")
fun bindRequiredPercentAnswers(textView: TextView,count: Int){
    textView.text = String.format(
        textView.context.getString(R.string.required_percentage),
        count
    )
}
@BindingAdapter("scorePercentage")
fun bindScorePercentAnswers(textView: TextView,gameResult: GameResult){
    textView.text = String.format(
        textView.context.getString(R.string.score_percentage),
        getPercentOfRightAnswers(gameResult)
    )
}
private fun getPercentOfRightAnswers(gameResult: GameResult) = with(gameResult) {
    if (countOfQuestions == 0) {
        0
    } else {
        ((countOfRightAnswers / countOfQuestions.toDouble()) * 100).toInt()
    }
}
@BindingAdapter("resultEmoji")
fun bindResultEmoji(imageView: ImageView,winner: Boolean){
    imageView.setImageResource(getSmileResId(winner))
}
private fun getSmileResId(isWin: Boolean): Int {
    return if (isWin) {
        R.drawable.ic_smile
    } else {
        R.drawable.ic_sad
    }
}

@BindingAdapter("progressAnswers")
fun bindProgressAnswers(textView: TextView,progressAnswers : LiveData<String>){
    textView.text = String.format(
            textView.context.getString(R.string.progress_answers),
            progressAnswers
    )
}

@BindingAdapter("enoughCount")
fun bindEnoughCount(textView: TextView,enoughCount : Boolean){
    textView.setTextColor(getColorByState(textView.context, enoughCount))
}
@BindingAdapter("enoughPercent")
fun bindEnoughPercent(progressBar: ProgressBar,enoughPercent : Boolean){
    val color = getColorByState(progressBar.context,enoughPercent)
    progressBar.progressTintList = ColorStateList.valueOf(color)
}
private fun getColorByState(context: Context , goodState: Boolean): Int {
    val colorResId = if (goodState) {
        android.R.color.holo_green_light
    } else {
        android.R.color.holo_red_light
    }
    return ContextCompat.getColor(context, colorResId)
}

@BindingAdapter("numberAsText")
fun bindNumberAsText(textView: TextView,number: Int){
    textView.text = number.toString()
}

@BindingAdapter("onOptionClickListener")
fun bindOnOptionClickListener(textView: TextView,clickListener: OnOptionClickListener){
    textView.setOnClickListener {
        clickListener.onOptionClick(textView.text.toString().toInt())
    }
}

interface OnOptionClickListener{
    fun onOptionClick(option: Int)
}