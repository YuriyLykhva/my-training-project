package io.testomat.api.controllers;

import io.testomat.api.common.ResponseDecorator;
import io.testomat.api.dtos.ProjectsDto;

public class ProjectController extends BaseController<ProjectController> {
    public ResponseDecorator getAllProjects() {
        return new ResponseDecorator(
                baseClient().get("/projects"),
                200,
                ProjectsDto.class);
    }
}
