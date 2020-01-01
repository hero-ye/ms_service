package com.hero.ms.service.tree.utils;

import com.hero.ms.service.tree.entity.TreeCode;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author yejx
 * @Date 2019/12/22
 */
public class TreeBuilder {

    List<TreeCode> nodes = new ArrayList<>();
    String parentId = null;

    public TreeBuilder(List<TreeCode> nodes) {
        super();
        this.nodes = nodes;
    }

    public TreeBuilder(List<TreeCode> nodes, String parentId) {
        this.nodes = nodes;
        this.parentId = parentId;
    }

    public TreeBuilder() {
    }

    // 构建树形结构
    public List<TreeNodes> buildTree() {
        List<TreeNodes> treeNodes = new ArrayList<>();
        List<TreeNodes> rootNodes = getRootNodes();
        for (TreeNodes rootNode : rootNodes) {
            buildChildNodes(rootNode);
            treeNodes.add(rootNode);
        }
        return StringUtils.isEmpty(this.parentId) ? treeNodes : treeNodes.size() == 1 ? new ArrayList(treeNodes.get(0).getChildren()) : treeNodes;
    }

    // 获取集合中所有的根节点
    public List<TreeNodes> getRootNodes() {
        List<TreeNodes> rootNodes = new ArrayList<>();
        for (TreeCode n : nodes) {
            if (StringUtils.isNotEmpty(parentId) && parentId.equals(n.getCodeId())) {
                rootNodes.add(new TreeNodes(n));
                break;
            } else if (StringUtils.isEmpty(parentId) && rootNode(n)) {
                rootNodes.add(new TreeNodes(n));
            }
        }
        return rootNodes;
    }

    // 判断是否为根节点
    public boolean rootNode(TreeCode node) {
        boolean isRootNode = true;
        for (TreeCode n : nodes) {
            // 所有节点中有节点的父节点id是输入节点node的id，就不是根节点
            if (n.getCodeId().equals(node.getParentId())) {
                isRootNode = false;
                break;
            }
        }
        return isRootNode;
    }

    // 获取父节点下所有的子节点
    public List<TreeNodes> getChildNodes(TreeNodes pnode) {
        List<TreeNodes> childNodes = new ArrayList<>();
        for (TreeCode n : nodes) {
            if (pnode.getId().equals(n.getParentId())) {
                childNodes.add(new TreeNodes(n));
            }
        }
        return childNodes;
    }


    // 递归子节点
    public void buildChildNodes(TreeNodes node) {
        List<TreeNodes> children = getChildNodes(node);
        if (!children.isEmpty()) {
            for (TreeNodes child : children) {
                buildChildNodes(child);
            }
            node.setChildren(children);
        }
    }



}
