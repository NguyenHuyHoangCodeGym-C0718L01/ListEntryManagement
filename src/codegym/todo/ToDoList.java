package codegym.todo;

public class ToDoList {
    private Entry[] list = new Entry[100];
    private int length = 0;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Entry[] getList() {
        return list;
    }

    public void setList(Entry[] list) {
        this.list = list;
    }

    public void addEntry(Entry entry){
        if(getLength() >= getList().length-1) {
            Entry[] anotherList = new Entry[getList().length + 1];
            for (int i = 0; i < getList().length; i++) {
                anotherList[i] = getList()[i];
            }
            setList(anotherList);
        }
        getList()[getLength()] = entry;
        setLength(getLength()+1);
    }

    public void showToDoList(){
        for(int i = 0; i < getLength(); i++){
            System.out.println("Entry "+i+": "+getList()[i].getPriority()+", "+getList()[i].getNotes());
        }
    }

    public void sortList(){
        for (int i = 0; i < getLength() - 1; i++)
        {
            int index = i;
            for (int j = i + 1; j < getLength(); j++){
                if (getList()[j].getPriority() < getList()[index].getPriority()){
                    index = j;//searching for lowest index
                }
            }
            Entry tempEntry = getList()[index];
            getList()[index] = getList()[i];
            getList()[i] = tempEntry;
        }
    }

    public boolean removeEntry(int id){
        for(int i = 0; i < getLength(); i++){
            if(id == getList()[i].getId()){
                for(int j = i; j < getLength(); j++){
                    getList()[j] = getList()[j+1];
                }
                setLength(getLength()-1);
                return true;
            }
        }
        return false;
    }

    public Entry getEntryById(int id){
        for(int i = 0; i < getLength(); i++) {
            if (id == getList()[i].getId()) {
                return getList()[i];
            }
        }
        return null;
    }
}
