// package org.endless.erp.game.eve.cost;

// import org.springframework.stereotype.Service;

// /**
//  * GameEveCostService
//  *
//  * @author Deng Haozhi
//  * @date 2023/4/28 22:43
//  * @since 0.0.2
//  */
// @Service
// public class GameEveCostService {

//     // private final MongoBulkOperations bulkMongoRepository;
//     //
//     // private final GameEveItemService gameEveItemService;
//     //
//     // private final GameEveFormulaService gameEveFormulaService;
//     //
//     // public GameEveCostService(MongoBulkOperations bulkMongoRepository, GameEveItemService gameEveItemService, GameEveFormulaService gameEveFormulaService) {
//     //     this.bulkMongoRepository = bulkMongoRepository;
//     //     this.gameEveItemService = gameEveItemService;
//     //     this.gameEveFormulaService = gameEveFormulaService;
//     // }
//     //
//     // public void update() {
//     //
//     //     var blueprints = gameEveFormulaService.getAll();
//     //
//     //     var items = gameEveItemService.getItemsByPublished(true);
//     //
//     //     List<Pair<Query, Update>> upsertList = new ArrayList<>();
//     //     items.stream().filter(item -> item.getPrice().getCurPrice() != null).forEach(item -> {
//     //
//     //         var manufacturingCost = getManufacturingCost(items, blueprints, item.getItemId());
//     //         if (manufacturingCost == null) manufacturingCost = item.getPrice().getCurPrice();
//     //
//     //         var query = Query.query(Criteria.where("item").is(item.getItemId()));
//     //         var update = Update.update("cost.manufacturingCost", DecimalTools.format128(manufacturingCost)).set("cost.manufacturingProcurementCost", DecimalTools.format128(getManufacturingProcurementCost(items, blueprints, item.getItemId()))).set("cost.isManufacturing", manufacturingCost.compareTo(item.getPrice().getCurPrice()) < 0);
//     //         upsertList.add(Pair.of(query, update));
//     //     });
//     //     bulkMongoRepository.upsert(upsertList, 1000, GameEveItem.class);
//     //     System.out.println("GameEveItemService updateCost executed!");
//     // }
//     //
//     // protected BigDecimal getManufacturingCost(List<GameEveItem> gameEveItems, List<GameEveFormula> gameEveFormulas, String productItemId) {
//     //
//     //     var cost = DecimalTools.format5Bit("0.00000");
//     //     var blueprint = gameEveFormulaService.getManufacturingBlueprint(gameEveFormulas, productItemId);
//     //     var curPrice = gameEveItemService.getCurPrice(gameEveItems, productItemId);
//     //
//     //     if (blueprint == null) return curPrice;
//     //
//     //     for (var material : blueprint.getManufacturing().getMaterials()) {
//     //         if (material.getTypeId().equals(productItemId)) return curPrice;
//     //         var consumption = DecimalTools.multiply(new BigDecimal("0.92"), material.getQuantity());
//     //         cost = DecimalTools.add(cost, DecimalTools.multiply(DecimalTools.format5Bit(consumption), getManufacturingCost(gameEveItems, gameEveFormulas, material.getTypeId())));
//     //     }
//     //
//     //     cost = DecimalTools.divide(cost, gameEveFormulaService.getManufacturingYield(blueprint, productItemId));
//     //
//     //     if (cost != null && curPrice != null && cost.compareTo(curPrice) > 0) return curPrice;
//     //     return cost;
//     // }
//     //
//     // protected BigDecimal getManufacturingProcurementCost(List<GameEveItem> gameEveItems, List<GameEveFormula> gameEveFormulas, String productItemId) {
//     //
//     //     var cost = DecimalTools.format5Bit("0.00000");
//     //     var blueprint = gameEveFormulaService.getManufacturingBlueprint(gameEveFormulas, productItemId);
//     //     var curPrice = gameEveItemService.getCurPrice(gameEveItems, productItemId);
//     //
//     //     if (blueprint == null) return curPrice;
//     //
//     //     for (var material : blueprint.getManufacturing().getMaterials()) {
//     //         if (material.getTypeId().equals(productItemId)) return curPrice;
//     //         var consumption = DecimalTools.multiply(new BigDecimal("0.92"), material.getQuantity());
//     //         cost = DecimalTools.add(cost, DecimalTools.multiply(DecimalTools.format5Bit(consumption), gameEveItemService.getCurPrice(gameEveItems, material.getTypeId())));
//     //     }
//     //
//     //     cost = DecimalTools.divide(cost, gameEveFormulaService.getManufacturingYield(blueprint, productItemId));
//     //
//     //     return cost;
//     // }
// }
