function [x,k,err] = SOR(A,b,w,x_0)

N = (tril(A)-diag(diag(A)))+diag(diag(A))/w;
P = N - A;
x = N \ P * x_0 + N \ b;
k=1;
err(1)=norm(x-x_0,2)/norm(x,2);

while err(k)>10^-3 && k<1000
    x_0 = x;
    x = N \ P * x + N \ b;
    k = k + 1;
    err(k)=norm(x-x_0,2)/norm(x,2);
end