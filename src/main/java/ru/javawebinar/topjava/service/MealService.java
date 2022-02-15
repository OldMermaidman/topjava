package ru.javawebinar.topjava.service;

import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.Collection;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFoundWithId;

@Service
public class MealService {

    private MealRepository repository;

    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    public MealTo create(Meal meal, Integer userId, int caloriesPerDay) {
        Meal savedMeal = repository.save(meal, userId);
        if (savedMeal == null) return null;
        Collection<MealTo> mealTos = getAll(userId, caloriesPerDay);
        return mealTos.stream().filter(m -> m.getId().equals(savedMeal.getId())).findFirst().orElse(null);
    }

    public void delete(int id, Integer userId) {
        checkNotFoundWithId(repository.delete(id, userId), id);
    }

    public MealTo get(int id, Integer userId, int caloriesPerDay) {
        MealTo mealtoFromDb = getAll(userId, caloriesPerDay).stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
        return checkNotFoundWithId(mealtoFromDb, id);
    }

    public Collection<MealTo> getAll(Integer userId, int caloriesPerDay) {
        return MealsUtil.getTos(repository.getAll(userId), caloriesPerDay);
    }

    public void update(Meal meal, Integer userId) {
        checkNotFoundWithId(repository.save(meal, userId), meal.getId());
    }
}