package com.apidev.firstapi.model;

import javax.validation.constraints.NotEmpty;

public record BookLibraryModel(String id, @NotEmpty String title, String description, String url, java.time.Year publishYear) {
}
