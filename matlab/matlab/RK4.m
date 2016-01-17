function [xT,error]=RK4(h)

N=1/h;
x=zeros(1,N+1);
x(1)=1;

for i=1:N;
    t=(i-1)*h;
    F1=h*f(t,x(i));
    F2=h*f(t+h/2,x(i)+F1/2);
    F3=h*f(t+h/2,x(i)+F2/2);
    F4=h*f(t+h,x(i)+F3);
    x(i+1)=x(i)+(1/6)*(F1+2*F2+2*F3+F4);
end

xT=x(N+1);
error=abs((1+1^4)-x(N+1));