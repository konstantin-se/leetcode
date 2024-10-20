
fun main() {
    // Creating nodes
    val l1 = ListNode(1)
            .apply { next = ListNode(0)
                    .apply { next = ListNode(1)
                    }}
    val l2 = ListNode(1)
            .apply { next = ListNode(0)
                    .apply { next = ListNode(1)
                            .apply { next = ListNode(9)
                                    .apply { next = ListNode(9)
                            } } }}


    val result = addTwoNumbers(l1, l2)

    // Print the result linked list
    var current = result
    while (current != null) {
        print(current.`val`)
        if (current.next != null) print(" -> ")
        current = current.next
    }
}


fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var listNode1 = l1
    var listNode2 = l2
    var carry = 0
    val dummyHead = ListNode(0)
    var current = dummyHead

    // Traverse both lists
    while (listNode1 != null || listNode2 != null) {
        val x = listNode1?.`val` ?: 0
        val y = listNode2?.`val` ?: 0
        val sum = carry + x + y

        carry = sum / 10
        current.next = ListNode(sum % 10)
        current = current.next!!

        listNode1 = listNode1?.next
        listNode2 = listNode2?.next
    }

    // Handle final carry
    if (carry > 0) {
        current.next = ListNode(carry)
    }

    return dummyHead.next
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}