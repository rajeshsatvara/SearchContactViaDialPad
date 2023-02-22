package com.rjz.contactsearch

class DummyData {

    companion object {
        fun getDummyData(): ArrayList<Contact> {
            val list = ArrayList<Contact>()
            list.add(Contact("Rajesh Satvara", "997848640183"))
            list.add(Contact("Raj Satvara", "99473183"))
            list.add(Contact("Berry Trantow", "45456434523"))
            list.add(Contact("Adella Wyman", "454532"))
            list.add(Contact("Effie Turcotte", "478346"))
            list.add(Contact("Leif Hahn", "99902583"))
            list.add(Contact("Norbert Flatley", "453453"))
            list.add(Contact("Lavinia Nader", "997845783183"))
            list.add(Contact("Monty Nader", "786786"))
            list.add(Contact("Anastacio Kihn", "378563753"))
            list.add(Contact("Winfield Hahn", "9958283183"))
            list.add(Contact("Cornell Grimes", "99753583183"))
            list.add(Contact("Guy Pfannerstill", "453453"))
            list.add(Contact("Hulda Konopelski", "997845783183"))
            list.add(Contact("Breanna Hand", "997845783183"))
            list.add(Contact("Dedric Ward", "997883783183"))
            list.add(Contact("Raj", "993742433"))
            list.add(Contact("Bobby Bailey", "9976924283183"))
            list.add(Contact("Mariela McCullough", "9968421783183"))
            list.add(Contact("Jadyn Dickens", "9978468242183"))
            list.add(Contact("Tremaine Hagenes", "9977283583"))
            list.add(Contact("Larry Heller", "99782183183"))
            list.add(Contact("Grayson Schuster", "997256863183"))
            list.sortBy {
                it.name.toString()
            }
            return list
        }
    }
}