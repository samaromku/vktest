package ru.savchenko.andrey.vktest

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

//    1)Дан массив чисел. дано расстояние k.
//    если числа в массиве находятся рядом то они на расстоянии 1 друг от друга.
//    нужно найти количество пар дублей, которые находятся на расстоянии k друг от друга
    @Test
    fun getDoubles() {
        val list = listOf(14, 14, 14, 14, 3, 56, 4, 52, 15, 14, 31, 15, 31)
        val k = 1
        var count = 0
        val set = mutableSetOf<Int>()
        val listOFDuplicateValue = mutableListOf<DuplicateValue>()

        list.forEachIndexed { index, value ->
            if (!set.add(value)) {
                val getDuplicate = listOFDuplicateValue.firstOrNull { it.value == value }
                if (getDuplicate != null) {
                    getDuplicate.mutableSet.add(index)
                } else {
                    val duplicate = DuplicateValue(value, mutableSetOf(list.indexOf(value), index))
                    listOFDuplicateValue.add(duplicate)
                }
            }
        }
        //get all duplicates
        for(duplicate in listOFDuplicateValue){
            //get all indexes of duplicates
            for(index in duplicate.mutableSet){
                for(anotherIndex in duplicate.mutableSet){
                    if(index-anotherIndex==k){
                        count++
                    }
                }
            }
        }
        println(count)
    }

    data class DuplicateValue(val value: Int,
                              val mutableSet: MutableSet<Int> = mutableSetOf())

    val test = """
        1)Дан массив чисел. дано расстояние k.
        если числа в массиве находятся рядом то они на расстоянии 1 друг от друга.
        нужно найти количество пар дублей, которые находятся на расстоянии k друг от друга

        2)Дан несортированный массив чисел. дана сумма какая то n.
        нужно выяснить есть ли в массиве два числа которые в сумме дают n

        3)Дана строка и число k,
        нужно найти максимальную по длине подстроку в этой строке
        в которой k- равно число уникальных символов.

        Пример: дана тестовая строка aabcbbacdaefeeefabeecda и k=4.

        Ответ: максимальная длина подстроки ровна 12 и она выглядит так daefeeefabee.



        4) public class TreeNode

        {


        public int Data;

        public TreeNode Left;

        public TreeNode Righ;


        }



        написать функцию считающую количество листьев



    """.trimIndent()
}
