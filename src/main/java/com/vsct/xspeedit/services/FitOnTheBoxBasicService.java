package com.vsct.xspeedit.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.vsct.xspeedit.exceptions.XspeeditIllegalException;
import com.vsct.xspeedit.models.Box;
import com.vsct.xspeedit.models.BoxPack;
import com.vsct.xspeedit.models.Item;

@Service
public class FitOnTheBoxBasicService implements FitOnTheBoxService {

	private static Logger LOGGER = LogManager.getLogger(FitOnTheBoxBasicService.class);

	/**
	 * fit on the box basic method : Takes the items one after another and puts them
	 * in the box. If the total size exceeds the capacity of the box, it puts the
	 * item in the following box
	 * @throws XspeeditIllegalException 
	 */
	@Override
	public BoxPack fitOnTheBox(String[] args, int capacity) throws XspeeditIllegalException {
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
			List<Item> itemsObj = new ArrayList<Item>();
			items.stream().forEach(it -> itemsObj.add(new Item(it)));
			BoxPack boxPack = new BoxPack();
			Box box = new Box(capacity);
			box = boxPack.addBox(box);
			for (Item item : itemsObj) {
				if (!box.add(item)) {
					box = new Box(capacity);
					box = boxPack.addBoxWithItem(box, item);
				}
			}
			LOGGER.info(boxPack.toString());
			return boxPack;
		}
	}

}
