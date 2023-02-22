package com.rjz.contactsearch

import java.util.*

class Util {
    companion object {
        fun getRegData(): HashMap<String, String> {
            val hmReg = HashMap<String, String>()
            hmReg["2"] = "[abc]"
            hmReg["3"] = "[def]"
            hmReg["4"] = "[ghi]"
            hmReg["5"] = "[jkl]"
            hmReg["6"] = "[mno]"
            hmReg["7"] = "[pqrs]"
            hmReg["8"] = "[tuv]"
            hmReg["9"] = "[wxyz]"
            hmReg["1"] = "[1]"
            hmReg["0"] = "[0]"
            return hmReg
        }

        fun isContactMatched(contact: Contact, finalRegEx: String, onlyDigit: String): Boolean {
            // check name first
            return if (contact.name.toString().uppercase()
                    .matches(Regex(finalRegEx.uppercase(Locale.getDefault())))
            ) {
                true
            } else {
                // check phone number
                digitsOnly(contact.phoneNumber).indexOf(onlyDigit) >= 0
            }
        }

        fun digitsOnly(s: String): String {
            val sb = StringBuilder()
            for (element in s) {
                if (Character.isDigit(element)) {
                    sb.append(element)
                }
            }
            return sb.toString()
        }
    }
}