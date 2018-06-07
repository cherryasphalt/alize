package systems.texture.alize.adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
    This class allows you to bundle a series of lists and other objects with their view types and
    treat it as a pseudo-list to make writing view adapters with heterogeneous models easier.
 */
public class AdapterMapper {
    protected ArrayList<Holder> holderList;
    protected int currentExpandedListLength;

    //true position, array position
    protected TreeMap<Integer, Integer> positionMap;

    public AdapterMapper() {
        holderList = new ArrayList<>();
        positionMap = new TreeMap<>();
        currentExpandedListLength = 0;
    }

    /*
        Adds an element to the AdapterMapper. If it's the first element of its view type, it will be
        added to a new mutable list. If an element is added and the previous element is of the same
        view type and in a mutable list, no new list will be created and the element will be
        appended to the previous list.
     */
    public <T> AdapterMapper add(int viewType, T object) {
        if (!holderList.isEmpty()) {
            Holder lastHolder = holderList.get(holderList.size() - 1);
            if (lastHolder.viewType == viewType && lastHolder.mutable) {
                lastHolder.content.add(object);
                currentExpandedListLength++;
                return this;
            }
        }
        ArrayList<Object> newList = new ArrayList<>();
        newList.add(object);
        holderList.add(new Holder<>(viewType, newList, true));
        positionMap.put(currentExpandedListLength, holderList.size() - 1);
        currentExpandedListLength += newList.size();
        return this;
    }

    public <T> AdapterMapper addList(int viewType, List<T> list) {
        holderList.add(new Holder<>(viewType, list));
        positionMap.put(currentExpandedListLength, holderList.size() - 1);
        currentExpandedListLength += list.size();
        return this;
    }

    /*
        Replaces the list that holds the element at the provided position with the provided list.
     */
    public AdapterMapper replaceListContainingIndex(int position, int viewType, List<?> list) {
        int holderIndex = positionMap.floorEntry(position).getValue();
        holderList.set(holderIndex, new Holder(viewType, list));
        updateMap();
        return this;
    }

    /*
        Removes the list that holds the element at the provided position.
     */
    public AdapterMapper removeListContainingIndex(int position) {
        int holderIndex = positionMap.floorEntry(position).getValue();
        holderList.remove(holderIndex);
        updateMap();
        return this;
    }

    /*
        Updates the internal position map. Should be used after changes that would invalidate it.
     */
    private void updateMap() {
        currentExpandedListLength = 0;
        int i = 0;
        positionMap.clear();
        for (Holder currentHolder : holderList) {
            positionMap.put(currentExpandedListLength, i++);
            currentExpandedListLength += currentHolder.content.size();
        }
    }

    public void clear() {
        holderList.clear();
        positionMap.clear();
        currentExpandedListLength = 0;
    }

    public Object get(int position) {
        if (!holderList.isEmpty() && isValidPosition(position)) {
            Map.Entry<Integer, Integer> entry = positionMap.floorEntry(position);
            int startIndex = entry.getKey();
            int holderIndex = entry.getValue();
            Holder holder = holderList.get(holderIndex);
            return holder.content.get(position - startIndex);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    private boolean isValidPosition(int position) {
        return position >= 0 && position < currentExpandedListLength;
    }

    public Object set(int position, Object element) {
        if (!holderList.isEmpty() && isValidPosition(position)) {
            Map.Entry<Integer, Integer> entry = positionMap.floorEntry(position);
            int startIndex = entry.getKey();
            int holderIndex = entry.getValue();
            Holder holder = holderList.get(holderIndex);
            return holder.content.set(position - startIndex, element);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public int getViewType(int position) {
        if (!holderList.isEmpty() && isValidPosition(position)) {
            int holderIndex = positionMap.floorEntry(position).getValue();
            return holderList.get(holderIndex).viewType;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean hasViewType(int viewType) {
        for (Holder holder : holderList)
            if (holder.viewType == viewType)
                return true;
        return false;
    }

    public <T> List<T> getListContainingIndex(int index) {
        if (!holderList.isEmpty() && isValidPosition(index)) {
            Map.Entry<Integer, Integer> entry = positionMap.floorEntry(index);
            Holder holder = holderList.get(entry.getValue());
            return holder.content;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public int findFirstOfViewType(int viewType) {
        int currentPosition = 0;
        for (Holder holder : holderList) {
            if (holder.viewType == viewType)
                return currentPosition;
            currentPosition += holder.content.size();
        }
        return -1;
    }

    public int size() {
        return currentExpandedListLength;
    }

    public boolean isEmpty() {
        return holderList.isEmpty();
    }

    protected static class Holder<T> {
        int viewType;
        List<T> content;
        boolean mutable;

        Holder(int viewType, List<T> list) {
            this(viewType, list, false);
        }

        Holder(int viewType, List<T> list, boolean mutable) {
            this.viewType = viewType;
            content = list;
            this.mutable = mutable;
        }
    }
}
