# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, lists):
        if not lists:
            return None

        result = lists[0]

        for i in range(1, len(lists)):
            result = self.merge(result, lists[i])

        return result

    def merge(self, a, b):
        dummy = ListNode(0)
        curr = dummy

        while a and b:
            if a.val < b.val:
                curr.next = a
                a = a.next
            else:
                curr.next = b
                b = b.next
            curr = curr.next

        curr.next = a or b

        return dummy.next
        