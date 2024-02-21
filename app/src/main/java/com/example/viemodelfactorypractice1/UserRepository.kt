package com.example.viemodelfactorypractice1

class UserRepository {
    fun getAllData() : List<User>{
        var list = arrayListOf<User>()
        for(a in 1..10){
            list.add((User(a.toString())))
        }
        list.add(User("JD"))
        list.add(User("Pratik"))
        list.add(User("Yashpal"))
        list.add(User("Darshan"))
        list.add(User("Devang"))
        list.add(User("Maulik"))
        list.add(User("Viren"))
        list.add(User("Vishal"))

        return list
    }

}