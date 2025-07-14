class Solution:
    def buildTree(self, inorder: List[int], postorder: list[int]) -> Optinal[TreeNode]:
        inorderIdx = {v:i for i, v in enumerate(inorder)}
        
        def helper(l, r):
        
            if l > r:
                return None
            
            root = TreeNode(postorder.pop())

            idx = inorder.index(root.val)
            root.right = helper(idx + 1, r)
            root.left = helper(l, idx - 1)
            return root
        
        return helper(0, len(inorder) - 1)