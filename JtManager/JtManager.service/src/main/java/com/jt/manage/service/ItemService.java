package com.jt.manage.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jt.manage.mapper.ItemMapper;
import com.jt.manage.pojo.Item;

@Service
public class ItemService extends BaseService<Item>{
	@Autowired
	private ItemMapper itemMapper;
	
	public PageInfo<Item> queryItemList(Integer page,Integer rows){
		PageHelper.startPage(page, rows);
		List<Item> items=itemMapper.queryItemList();
		PageInfo<Item> pageInfo=new PageInfo<Item>(items);
		return pageInfo;
	}
	
	public void saveItem(Item item){
		item.setStatus(1);
		item.setCreated(new Date());
		item.setUpdated(item.getCreated());
		itemMapper.insertSelective(item);
	}
	
	public void updateItem(Item item){
		item.setUpdated(new Date());
		itemMapper.updateByPrimaryKeySelective(item);
	}
	
	public void deleteItems(Long[] ids){
		itemMapper.deleteByIDS(ids);
	}
	
}
