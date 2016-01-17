function [xT,error]=Euler(h)

N=1/h;
x=zeros(1,N+1);
x(1)=1;

for i=1:N;
    t=(i-1)*h;
    f=(4*(t^3)*x(i))/(1+t^4);
    x(i+1)=x(i)+h*f;
end

xT=x(N+1);
error=abs((1+1^4)-x(N+1));