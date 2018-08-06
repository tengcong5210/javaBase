package com.java.gitlab;

import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.ProjectApi;
import org.gitlab4j.api.RepositoryApi;
import org.gitlab4j.api.models.Branch;
import org.gitlab4j.api.models.Project;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @创建人 tengcc
 * @创建时间 2018/8/6
 * @描述
 */
public class GitApiClient {

    public static void main(String[] args) {

        //参考文献：https://github.com/gmessner/gitlab4j-api
        try {
            GitLabApi gitLabApi = GitLabApi.login("http://your.gitlab.server.com", "your-username", "your-password");

            Project  project=gitLabApi.getProjectApi().getProject("ApplicationOps","Secret_CD");
            System.out.println("项目名称:"+project.getName());

            RepositoryApi repositoryApi =gitLabApi.getRepositoryApi();
            Branch branch = repositoryApi.createBranch(project.getId(), "TestApiCreate", "master");
            assertNotNull(branch);

            Branch fetchedBranch=repositoryApi.getBranch(project.getId(),"TestApiCreate");
            assertNotNull(fetchedBranch);

            assertEquals(branch.getName(), fetchedBranch.getName());

            System.out.println("newBranch:"+branch.getName()+";getNewBranch:"+fetchedBranch.getName());

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
