package hello.springmvc.domain;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository       //component 잇어서 스프링 등록
public class ItemRepository {

    private static final Map<Long,Item> store = new HashMap<>();
    private static Long sequence = 0L;

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(),item);
        return item;
    }
    public Item findById(Long id){
        return store.get(id);
    }
    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }
    public void update(Long itemId,Item updateparam){
        Item findItem = findById(itemId);
        findItem.setItemName(updateparam.getItemName());
        findItem.setPrice(updateparam.getPrice());
        findItem.setQuantity(updateparam.getQuantity());
    }
    public void clearStore(){
        store.clear();

    }

}
