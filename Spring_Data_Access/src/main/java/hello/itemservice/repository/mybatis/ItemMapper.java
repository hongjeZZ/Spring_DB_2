package hello.itemservice.repository.mybatis;

import hello.itemservice.domain.Item;
import hello.itemservice.repository.ItemSearchCond;
import hello.itemservice.repository.ItemUpdateDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ItemMapper {

    void save(Item item);

    // 파라미터가 2개 이상이면, @Param 애노테이션을 붙여주어야 한다.
    void update(@Param("id") Long id, @Param("updateParam") ItemUpdateDto updateDto);

    Optional<Item> findById(Long id);

    List<Item> findAll(ItemSearchCond itemSearchCond);
}
