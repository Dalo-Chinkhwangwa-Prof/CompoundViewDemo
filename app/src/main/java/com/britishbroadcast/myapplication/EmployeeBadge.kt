package com.britishbroadcast.myapplication

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class EmployeeBadge(context: Context, var attributeSet: AttributeSet) :
    ConstraintLayout(context, attributeSet) {

    var employeeName: String
        get() = employeeNameTextView.text.toString()
        set(value) {
            employeeNameTextView.text = value
        }

    var employeeID: String
        get() = employeeIDTextView.text.toString()
        set(value) {
            employeeIDTextView.text = value
        }

    var employeeTitle: String
        get() = employeeTitleTextView.text.toString()
        set(value) {
            employeeTitleTextView.text = value
        }

    private var employeeNameTextView: TextView
    private var employeeIDTextView: TextView
    private var employeeTitleTextView: TextView

    private val inflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    init {
        val view = inflater.inflate(R.layout.badge_layout, this, true)

        employeeIDTextView = view.findViewById(R.id.employeeid_textview)
        employeeNameTextView = view.findViewById(R.id.employeename_textview)
        employeeTitleTextView = view.findViewById(R.id.employeetitle_textview)

        val typedArray = context.obtainStyledAttributes(
            attributeSet,
            R.styleable.EmployeeBadge
        )

        employeeName = typedArray.getString(R.styleable.EmployeeBadge_employeeName) ?: ""
        employeeID = typedArray.getString(R.styleable.EmployeeBadge_employeeID) ?: ""
        employeeTitle = typedArray.getString(R.styleable.EmployeeBadge_employeeTitle) ?: ""
    }

}