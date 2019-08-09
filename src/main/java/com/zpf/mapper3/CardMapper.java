package com.zpf.mapper3;

import com.zpf.domain.Card;
import org.apache.ibatis.annotations.Select;

public interface CardMapper {
    @Select("select *from tb_card where id=#{id}")
    Card SelectCardById(Integer id);
}
