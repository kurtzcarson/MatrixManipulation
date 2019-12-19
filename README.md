# MatrixManipulation

This project is designed to row reduce square matrices into Echelon form to find their solutions and determine various other matrix properties based on the principles I have learned in Linear Algebra.

The Matrix class is designed to provide the fundamental functionality of square and non-square matrices and their elementary row operations.

The SquareMatrix class extends the Matrix class and has functions designed to only work with square matrices. I am still working on adding additional functionality for non-square matrices. 

The IdentityMatrix class creates identity matrices that are currently utilized for determining the inverse of square matrices larger than 2x2 and will be utilitized for future eigenvalue functionality. 

Ideally, by the time this project is completed, I will be able to output the number of basic and free variables of matrices to determined whether or not a matrix is linearly dependent. I will also be able determine whether solutions are one to one relationships and if that span a given space R. I also plan on making a NonSquare Matrix class. In the future, this may completely replace the SquareMatrix class as the functionality will prove to be more general. I plan on being able to generate random matrices and then determinign their properties instead of needs direct input from the user. 

