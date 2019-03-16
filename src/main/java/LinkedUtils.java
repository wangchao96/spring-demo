public class LinkedUtils<T> {
    /**
     * 链表反转-迭代法
     * 先将下一节点纪录下来，然后让当前节点指向上一节点，再将当前节点纪录下来,再让下一节点变为当前节点
     *
     * @param node
     * @return
     */
    public Node<T> reverse1(Node<T> node) {
        if (node == null) {
            return null;
        }
        Node<T> pre = null;
        Node<T> now = node;
        while (now != null) {
            Node<T> next = now.getNext();
            now.setNext(pre);
            pre = now;
            now = next;
        }
        return pre;
    }

    /**
     * 链表反转-递归法1
     * 先找到最后一个节点，然后从最后一个开始反转,然后当前节点反转时其后面的节点已经进行反转了，不需要管。最后返回原来的最后一个节点
     *
     * @param node
     * @param pre
     * @return
     */
    public Node<T> reverse2(Node<T> node, Node<T> pre) {
        if (node == null) {
            return null;
        }
        if (node.getNext() == null) {
            node.setNext(pre);
            return node;
        }
        Node<T> result = reverse2(node.getNext(), node);
        node.setNext(pre);
        return result;
    }

    /**
     * 链表反转-递归法2
     * 先找到最后一个节点，然后从最后一个节点之前的那个节点的方法体中开始将下一个指向当前一个,然后当前节点反转时其后面的节点已经进行反转了，不需要管。最后返回原来的最后一个节点。
     *
     * @param node
     * @return
     */
    public Node<T> reverse3(Node<T> node) {
        if (node == null) {
            return null;
        }
        if (node.getNext() == null) {
            return node;
        }
        Node<T> next = node.getNext();
        node.setNext(null);
        Node<T> re = reverse3(next);
        next.setNext(node);
        return re;
    }

    /**
     * 判断链表是否有环
     *
     * @param node
     * @return
     */
    public boolean isExistLoop(Node<T> node) {
        // 定义两个指针fast和slow,fast移动步长为2，slow移动步长为1
        Node<T> slow = node;
        Node<T> fast = node;
        boolean flag = false;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            //如果相遇则存在环儿，跳出
            if (fast == slow) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * 计算有环链表长度
     * fast, slow从碰撞点出发再次碰撞就是环儿的长度
     *
     * @param node
     * @return
     */
    public int loopLength(Node<T> node) {
        // 定义两个指针fast和slow,fast移动步长为2，slow移动步长为1
        Node<T> slow = node;
        Node<T> fast = node;
        boolean begin = false;
        int length = 0;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            // 第二次相遇跳出
            if (fast == slow && begin) {
                break;
            }
            // 第一次相遇开始计数
            if (fast == slow) {
                begin = true;
            }
            if (begin) {
                length++;
            }
        }
        return length;
    }

    /**
     * 查找有环链表成环节点
     * 碰撞点到连接点的距离=头指针到连接点的距离<br>
     * 因此，分别从碰撞点、头指针开始走，相遇的那个点就是连接点<br>
     *
     * @param node
     * @return
     */
    public Node<T> findLoopEntrance(Node<T> node) {
        Node<T> fast = node;
        Node<T> slow = node;
        Node<T> root = node;
        Node<T> crashNode = null;
        Node<T> loopNode = null;
        while (fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();

            if (fast == slow){
                // 碰撞点
                crashNode = fast;
            }

            if (crashNode != null){
                // 同时从成环点和碰撞点出发
                root = root.getNext();
                crashNode = crashNode.getNext();
            }

            if (root == crashNode){
                // 相遇
                loopNode = crashNode;
                break;
            }
        }
        return loopNode;
    }

    public void printNode(Node<T> node) {
        while (node != null) {
            System.out.println(node.getData());
            node = node.getNext();
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        LinkedUtils<Integer> linkedUtils = new LinkedUtils<Integer>();
        Node<Integer> node1 = new Node<Integer>(1, null);
        Node<Integer> node2 = new Node<Integer>(2, null);
        Node<Integer> node3 = new Node<Integer>(3, null);
        Node<Integer> node4 = new Node<Integer>(4, null);
        Node<Integer> node5 = new Node<Integer>(5, null);
        Node<Integer> node6 = new Node<Integer>(6, null);
        Node<Integer> node7 = new Node<Integer>(7, null);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node7);
        node7.setNext(node3);
        System.out.println(linkedUtils.isExistLoop(node1));
        System.out.println(linkedUtils.loopLength(node1));
        System.out.println(linkedUtils.findLoopEntrance(node1).getData());
    }
}
