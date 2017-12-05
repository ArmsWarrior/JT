package com.jt.manage.mapper;

import com.jt.common.mapper.SysMapper;
import com.jt.manage.pojo.ItemCat;

//继承通用mapper,通用mapper没有批量删除
//所以我们自定义了sysmapper进行批量操作
public interface ItemCatMapper extends SysMapper<ItemCat>{

}
