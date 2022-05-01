package net.devstudy.resume.service;

import net.devstudy.resume.entity.jpa.Profile;

public interface SocialService<T> {

    Profile loginViaSocialNetwork(T model);
}
