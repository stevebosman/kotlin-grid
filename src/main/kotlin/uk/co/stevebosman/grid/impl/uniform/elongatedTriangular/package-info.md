# Package uk.co.stevebosman.grid.impl.regular.elongatedTriangular

Each cell of the triangular grid is identified by a unique coordinate (x,y) such that:

* even number rows (y%2==0) start with an up elongatedTriangular 🔺 at x=0
* odd number rows (y%2==1) start with a down elongatedTriangular 🔻 at x=0

Exploded pattern:

```
y  
4 🔺🔻🔺🔻🔺  
3 🔻🔺🔻🔺🔻  
2 🔺🔻🔺🔻🔺  
1 🔻🔺🔻🔺🔻  
0 🔺🔻🔺🔻🔺  
```
