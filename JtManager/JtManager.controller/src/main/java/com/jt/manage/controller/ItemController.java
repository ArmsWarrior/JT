package com.jt.manage.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.jt.common.vo.EasyUIResult;
import com.jt.common.vo.SysResult;
import com.jt.manage.pojo.Item;
import com.jt.manage.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	private static final Logger log=Logger.getLogger(ItemController.class);
	
	@RequestMapping("/query")
	@ResponseBody
	public EasyUIResult queryItemList(Integer page,Integer rows){
		PageInfo<Item> pageInfo=itemService.queryItemList(page,rows);
		return new EasyUIResult(pageInfo.getTotal(),pageInfo.getList());
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public SysResult saveItem(Item item){
		try {
			itemService.saveItem(item);
			return SysResult.oK();
		} catch (Exception e) {
			String message=e.getMessage();
			log.error(message);
			return SysResult.build(201, "新增商品失败！"+message);
		}
		
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public SysResult updateItem(Item item){
		try {
			itemService.updateItem(item);
			return SysResult.oK();
		} catch (Exception e) {
			String message=e.getMessage();
			log.error(message);
			return SysResult.build(202, "修改商品失败"+message);
		}
	}
	@RequestMapping("/delete")
	@ResponseBody
	public SysResult deleteItems(Long[] ids){
		try {
			itemService.deleteByIds(ids);
			return SysResult.oK();
		} catch (Exception e) {
			String message=e.getMessage();
			log.error(message);
			return SysResult.build(203, "删除商品失败"+message);
		}
	}
}
