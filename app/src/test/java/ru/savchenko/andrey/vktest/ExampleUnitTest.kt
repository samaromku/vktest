package ru.savchenko.andrey.vktest

import org.junit.Test

import org.junit.Assert.*
import java.util.*


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
        for (duplicate in listOFDuplicateValue) {
            //get all indexes of duplicates
            for (index in duplicate.mutableSet) {
                for (anotherIndex in duplicate.mutableSet) {
                    if (index - anotherIndex == k) {
                        count++
                    }
                }
            }
        }
        println(count)
    }

    data class DuplicateValue(val value: Int,
                              val mutableSet: MutableSet<Int> = mutableSetOf())

    //    2)Дан несортированный массив чисел. дана сумма какая то n.
//    нужно выяснить есть ли в массиве два числа которые в сумме дают n
    @Test
    fun getSumPair() {
        val array = listOf<Int>(1, 2, 3, 6, 13, 12, 2, 34, 15, 15)
        val totalSum = 25
        val set = HashSet<Int>()
        for (num in array) {
            if (set.contains(totalSum - num)) {
                println("$num, ${(totalSum - num)} add up to totalSum")
                return
            }
            set.add(num)
        }
        println("no pair of numbers totalSum: $totalSum")
    }


//    3)Дана строка и число k,
//    нужно найти максимальную по длине подстроку в этой строке
//    в которой k- равно число уникальных символов.
//
//    Пример: дана тестовая строка aabcbbacdaefeeefabeecda и k=4.
//
//    Ответ: максимальная длина подстроки ровна 12 и она выглядит так daefeeefabee.
//    не понял задания. здесь 5 уникальных символов daefeeefabee a, b, d, e, f

    @Test
    fun getMaxSubString() {

    }


    //    4) public class TreeNode
//    {
//        public int Data
//        public TreeNode Left
//        public TreeNode Righ
//    }
//    написать функцию считающую количество листьев
    @Test
    fun getTreeCount() {

        val testNode = TreeNode(1,
                TreeNode(0, null,
                        TreeNode(0, null, null)),
                TreeNode(1,
                        TreeNode(0,
                                TreeNode(1, null, null),
                                TreeNode(1, null, null)), null))
        println(countLeaves(testNode))

    }

    fun countLeaves(node: TreeNode?): Int {
        if (node == null) {
            return 0
        }
        if (node.left == null && node.right == null) {
            return 1
        }
        return countLeaves(node.left) + countLeaves(node.right)
    }

    data class TreeNode(
            val data: Int?,
            val left: TreeNode?,
            val right: TreeNode?
    )
}
