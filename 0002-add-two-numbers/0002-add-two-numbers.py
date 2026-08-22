# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, a, b):
        return self.add(a, b, 0)

    def add(self, a, b, c):
        if not a and not b and not c:
            return None

        s = c + (a.val if a else 0) + (b.val if b else 0)
        n = ListNode(s % 10)

        n.next = self.add(a.next if a else None,
                          b.next if b else None, s // 10)
        return n
        