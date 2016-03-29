/**
 * 
 */
package events;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author joelmanning
 *
 */
public class EventBus
{
    private TreeNode<Class<? extends GameEvent>, ListNode<Integer, GameListener>> listeners;
    private Stack<EventResolver> stack;

    public EventBus()
    {
        listeners = new TreeNode<Class<? extends GameEvent>, ListNode<Integer, GameListener>>(
                GameEvent.class, null);
    }

    public void addListener(Class<? extends GameEvent> listened,
            GameListener listener, int priority)
    {
        TreeNode<Class<? extends GameEvent>, ListNode<Integer, GameListener>> current = listeners;
        while (!(current.getKey().equals(listened)))
        {
            if (current.getChildren() == null)
            {
                current.setChildren(new ArrayList<TreeNode<Class<? extends GameEvent>, ListNode<Integer, GameListener>>>());
                current.add(new TreeNode<Class<? extends GameEvent>, ListNode<Integer, GameListener>>(
                        listened, null));
            }
            for (int i = 0; i < current.size(); i++)
            {
                TreeNode<Class<? extends GameEvent>, ListNode<Integer, GameListener>> node = current
                        .get(i);
                if (node.getKey().isAssignableFrom(listened))
                {
                    current = node;
                    break;
                }
                else if (listened.isAssignableFrom(node.getKey()))
                {
                    TreeNode<Class<? extends GameEvent>, ListNode<Integer, GameListener>> temp = current
                            .get(i);
                    current.set(
                            i,
                            new TreeNode<Class<? extends GameEvent>, ListNode<Integer, GameListener>>(
                                    new ArrayList<TreeNode<Class<? extends GameEvent>, ListNode<Integer, GameListener>>>(),
                                    listened, null));
                    current.get(i).add(temp);
                    current = current.get(i);
                    break;
                }
            }
        }
        current.setValue(add(current.getValue(), priority, listener));
    }

    public ListNode<Integer, GameListener> add(
            ListNode<Integer, GameListener> list, int priority,
            GameListener listener)
    {
        if (list == null)
        {
            return new ListNode<Integer, GameListener>(priority, listener);
        }
        if (list.getKey() >= priority)
        {
            list = new ListNode<Integer, GameListener>(list, priority, listener);
        }
        else
        {
            ListNode<Integer, GameListener> current = list;
            while (current.getNext() != null
                    && current.getNext().getKey() < priority)
            {
                current = current.getNext();
            }
            current.setNext(new ListNode<Integer, GameListener>(current
                    .getNext(), priority, listener));
        }
        return list;
    }

    public void fireEvent(GameEvent e)
    {
        stack.push(new EventResolver(e));
    }

    class EventResolver
    {
        private GameEvent toResolve;

        public EventResolver(GameEvent e)
        {
            toResolve = e;
            //grabs all min listeners
            //activates min of min listeners
            //makes activated listener next
            //what if a listener is removed?
        }

        /**
         * resolves one step of this event
         * 
         * @return whether there is more to be resolved
         */
        public boolean resolve()
        {
            //resolve 1 step, then maybe resolve the top of the stack until this object is on top
            return false;
        }
    }
}
