function [norm_u,norm_exactu,error]=assig3(h)

r=0.4;

N=1/h;
x=linspace(0,1,N+1);

u=zeros(N+1,101);

for i=1:N
    u(i,1)=sin(pi*x(i));
end

for n=2:101
    u(1,n)=0;
    u(N+1,n)=0;
end

for n=1:100
    for i=2:N
        u(i,n+1)=r*u(i+1,n)+(1-2*r)*u(i,n)+r*u(i-1,n);
    end
end

norm_u=norm(u(:,101)',Inf);

exactu=exp(-pi^2)*sin(pi*x);
norm_exactu=norm(exactu',Inf);

error=max(abs(u(:,101)-exactu'));