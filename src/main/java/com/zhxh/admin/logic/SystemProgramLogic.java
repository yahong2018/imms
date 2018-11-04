package com.zhxh.admin.logic;

import com.zhxh.admin.dao.SystemProgramDAO;
import com.zhxh.admin.entity.SystemProgram;
import com.zhxh.admin.vo.SystemProgramWithChildren;
import com.zhxh.core.data.EntityObject;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Component("systemProgramLogic")
public class SystemProgramLogic {
	@Resource(name="systemProgramDAO")
	SystemProgramDAO systemProgramDAO;

	public List<SystemProgram> getAll() {
		return systemProgramDAO.getAll();
	}

	public List getPageList(Map map, Map parameters) {
		return systemProgramDAO.getPageList(map, parameters);
	}

	public int getPageListCount(Map map, Map parameters) {
		return systemProgramDAO.getPageListCount(map, parameters);
	}
	
	 public List<SystemProgramWithChildren> getAllWithChildren() {
			List<SystemProgramWithChildren> result = new ArrayList<>();
			List<SystemProgram> systemProgramsList = systemProgramDAO.getAll();
			SystemProgram[] company = systemProgramsList.stream().filter(x -> x.getProgramId().equals(x.getParent())).toArray(SystemProgram[]::new);
			for (int a = 0; a < company.length; a++) {

				SystemProgramWithChildren companyWithChildren = new SystemProgramWithChildren();
				EntityObject.copy(company[a], companyWithChildren);
				SystemProgram[] childrenSystemProgram = systemProgramsList.stream()
						 .filter(SystemProgram::isTopMenu)
		                 .sorted(Comparator.comparing(SystemProgram::getShowOrder))
			             .toArray(SystemProgram[]::new);
				
				SystemProgramWithChildren[] children = new SystemProgramWithChildren[childrenSystemProgram.length];
				companyWithChildren.setChildren(children);

				for (int i = 0; i < children.length; i++) {
					SystemProgram child = childrenSystemProgram[i];
					SystemProgramWithChildren sub = new SystemProgramWithChildren();
					EntityObject.copy(child, sub);
					this.systemProgram2Tree(sub, systemProgramsList);

					children[i] = sub;
				}

				result.add(companyWithChildren);
			}
			return result;
		}

		private void systemProgram2Tree(SystemProgramWithChildren parent, List<SystemProgram> systemProgramsList) {
			 
			SystemProgram[] childrenSystemProgram = systemProgramsList.stream()
					 .filter(
		                        x -> x.getParent().equals(parent.getProgramId()) && (!x.getProgramId().equals(parent.getProgramId()))
		                ).sorted(Comparator.comparing(SystemProgram::getShowOrder))
		                .toArray(SystemProgram[]::new);
			SystemProgramWithChildren[] children = new SystemProgramWithChildren[childrenSystemProgram.length];
			parent.setChildren(children);
			for (int i = 0; i < children.length; i++) {
				SystemProgram child = childrenSystemProgram[i];
				SystemProgramWithChildren sub = new SystemProgramWithChildren();
				EntityObject.copy(child, sub);
				children[i] = sub;

				this.systemProgram2Tree(sub, systemProgramsList);
			}
		}
}
