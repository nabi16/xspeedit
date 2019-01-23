package com.vsct.xspeedit.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.vsct.xspeedit.exceptions.XspeeditIllegalException;
import com.vsct.xspeedit.models.Box;
import com.vsct.xspeedit.models.BoxPack;
import com.vsct.xspeedit.models.Item;

@Service
public class FitOnTheBoxAdvancedService implements FitOnTheBoxService {

	/**
	 * LOGGER
	 */
	private static Logger LOGGER = LogManager.getLogger(FitOnTheBoxAdvancedService.class);

	@Override
	public BoxPack fitOnTheBox(String[] args, int capacity) throws XspeeditIllegalException, NumberFormatException {

		if (args == null || args.length == 0) {
			throw new XspeeditIllegalException("Une erreur est survenue: Le paramètre d'entrée ne peut être null.");
		} else if (args.length > 1) {
			throw new XspeeditIllegalException(
					"Une erreur est survenue: Le nombre de paramètres en entrée ne peut être supérieur à 1.");
		} else {
			
			List<Integer> items = args[0].chars().peek(character-> {
				if (!Character.isDigit(character)) {
					throw new NumberFormatException("Le format du paramètre d'entrée n'est pas valide. Le paramètre ne doit contenir que des chiffres, exemple: 9914532778.");
				}
			}).mapToObj(intArg -> Character.getNumericValue(intArg))
					.collect(Collectors.toList());

			// sort the list in descending order to have the biggest items first
			Collections.sort(items, Collections.reverseOrder());
			List<Item> itemsObj = new ArrayList<Item>();
			items.stream().forEach(it -> itemsObj.add(new Item(it)));

			BoxPack boxPack = new BoxPack();
			Box box = new Box(capacity);

			// while items have not been added yet
			while (itemsObj.stream().anyMatch(item -> !item.isAdded())) {
				final Box currentBox = box;

				// filter to find an item that can be added to the current box
				Optional<Item> itemToAdd = itemsObj.stream()
						.filter(itemObj -> !itemObj.isAdded() && currentBox.canFit(itemObj)).findFirst();
				// if an item is found
				if (itemToAdd.isPresent()) {
					box.add(itemToAdd.get());
				}

				// if the box is full or no item found to fit the current box
				if (box.isFull() || !itemToAdd.isPresent()) {
					boxPack.addBox(box);
					box = new Box(capacity);
				}

			}

			LOGGER.info(boxPack.toString());
			return boxPack;

		}
	}

}
