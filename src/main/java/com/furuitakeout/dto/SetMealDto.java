package com.furuitakeout.dto;

import com.furuitakeout.domain.Dish;
import com.furuitakeout.domain.Setmeal;
import com.furuitakeout.domain.SetmealDish;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SetMealDto extends Setmeal {
    private List<SetmealDish> setmealDishes = new ArrayList<>();
    private String categoryName;
}
