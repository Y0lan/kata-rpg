# kata-rpg
# Solution to kata RPG
# Kata RPG

## First iteration: Characters

* A `Character` should have a `name` and a `health` pool.
* A `Character`'s `health` is initialized at `100` and cannot go above this value.
* A `Character` can either be `alive` or `dead` - when it reaches `0` `health` points. 
* A `Character` can `attack` another `Character` and deal `1` damage point to its enemy's `health` if it isn't already
 `dead`. A `Character` *cannot* attack itself...
* A `Character` can `heal` another `Character` and return `1` point to its ally's `health` pool. A `Character` *can* 
 heal itself!

## Second iteration: Warrior
> A `Character` can now have a job! Create a `jobs` package to store them.

* A `Warrior` is a `Character` that deals between `0` and `9` damage points to its enemy's `health`! Moreover, a `Warrior`
 *can* attack itself...
* A `Warrior` can *only* heal itself.

## Third iteration: Mage

* A `Mage` is a `Character` that *cannot* deal any damage.
* A `Mage` can heal another `Character` and return between `5` and `10` points to its ally's `health` pool.
* From now on, a `Character` *cannot* exist without a job.


## Fourth iteration: Factions \#1
> A `Character` may now belong to a `Faction`!

* A newly created `Character` doesn't belong to any `Faction`.
* A `Character` can `join` a `Faction`.
* A `Character` can `leave` its `Faction`.
* A `Character` *cannot* deal damage to another `Character` of the same `Faction`.
* A `Character` can *only* heal another `Character` of the same `Faction`.


## Fifth iteration: Entities

* A `Character` can now damage non-character *entities*.
* Anything that has `health` is considered an `Entity`.
* An `Entity` cannot deal damage and cannot heal nor be healed.
* An `Entity` cannot belong to a `Faction`.

## Sixth iteration: Factions \#2

* A `Faction` may now declare one or more `Faction`s as friends.
* A `Character` *cannot* deal damage to another `Character` of the same `Faction` or of one of its friends.
* A `Character` can *only* heal another `Character` of the same `Faction` or of one of its friends.

## Seventh iteration: Factions \#3

* A `Character` may now belong to one or more `Faction`s...

### Me contacter hors des cours : vfries1 @ myges.fr
### Rendu du TP sur myGES *obligatoire* avant 17h15
### Une étape de rendu facultative est ouverte jusqu'à dimanche 23h59 pour les groupes qui souhaitent terminer.
